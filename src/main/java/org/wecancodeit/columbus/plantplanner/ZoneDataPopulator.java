package org.wecancodeit.columbus.plantplanner;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Component
public class ZoneDataPopulator implements CommandLineRunner {

	@SuppressWarnings("unused")
	private Logger log = LoggerFactory.getLogger(ZoneDataPopulator.class);

	@Resource
	private ZipCodeLocalityRepository zipCodeLocalityRepo;

	@Resource
	private PrismZoneDataRepository prismZoneDataRepo;

	@Override
	public void run(String... args) throws Exception {

	
		insertZipCodeLocalityData("/US.txt");
		insertPrismCsv("/phm_hi_zipcode.csv");
		insertPrismCsv("/phm_pr_zipcode.csv");
		insertPrismCsv("/phm_ak_zipcode.csv");
		insertPrismCsv("/phm_us_zipcode.csv");

	}

	private void insertZipCodeLocalityData(String csvFileName) throws IOException, JsonProcessingException {
		CsvSchema geoNameSchema = CsvSchema.builder().setColumnSeparator('\t')
				.addColumn("") // country code : iso 2 char
				.addColumn("zipcode") // postal code : varchar(20)
				.addColumn("city") // place name : varchar(180)
				.addColumn("stateFull") // admin name1 : 1. order subdivision (state) varchar(100)
				.addColumn("stateAbbr") // admin code1 : 1. order subdivision (state) varchar(20)
				.addColumn("county") // admin name2 : 2. order subdivision (county/province) varchar(100)
				.addColumn("fipsCode") // admin code2 : 2. order subdivision (county/province) varchar(20)
				.addColumn("") // admin name3 : 3. order subdivision (community) varchar(100)
				.addColumn("") // admin code3 : 3. order subdivision (community) varchar(20)
				.addColumn("latitude", CsvSchema.ColumnType.NUMBER) // latitude : estimated latitude (wgs84)
				.addColumn("longitude", CsvSchema.ColumnType.NUMBER) // longitude : estimated longitude (wgs84)
				.addColumn("") // accuracy : accuracy of lat/lng from 1=estimated to 6=centroid
				.build();

		ObjectMapper mapper = new CsvMapper();
		ClassPathResource resource = new ClassPathResource(csvFileName);
		File file = resource.getFile();
		MappingIterator<ZipCodeLocality> it = mapper.readerFor(ZipCodeLocality.class).with(geoNameSchema)
				.with(Feature.IGNORE_TRAILING_UNMAPPABLE).readValues(file);
		zipCodeLocalityRepo.save(it.readAll());
	}

	private void insertPrismCsv(String csvFileName) throws IOException, JsonProcessingException {

		ClassPathResource resource = new ClassPathResource(csvFileName);
		ObjectMapper mapper = new CsvMapper();

		File file = resource.getFile();
		CsvSchema schema = CsvSchema.emptySchema().withHeader(); // use first row as header; otherwise defaults are fine

		MappingIterator<PrismZoneData> prismIt = mapper.readerFor(PrismZoneData.class).with(schema).readValues(file);

		while (prismIt.hasNext()) {
			PrismZoneData data = prismIt.next();
			ZipCodeLocality locality = zipCodeLocalityRepo.findOneByZipcode(data.zipcode);
			data = prismZoneDataRepo.save(data);
			if (locality != null) {
				zipCodeLocalityRepo.save(locality.addZoneData(data));
			}
		}

	}


}
