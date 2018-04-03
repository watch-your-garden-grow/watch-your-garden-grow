package org.wecancodeit.columbus.plantplanner;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ZipCodeZoneDataPopulator implements CommandLineRunner {
	
	private Logger log = LoggerFactory.getLogger(ZipCodeZoneDataPopulator.class);
	
		@Resource
		private ZipCodeZoneDataRepository zipCodeRepo;

		@Override
		public void run(String... args) throws Exception {

			ZipCodeZoneData zipCodeZoneData;
			
			zipCodeZoneData = zipCodeRepo.save(new ZipCodeZoneData("43202", "6a"));
			log.error(zipCodeZoneData.toString());
			
			zipCodeZoneData = zipCodeRepo.save(new ZipCodeZoneData("33101", "10b"));
			log.error(zipCodeZoneData.toString());

		}
}
