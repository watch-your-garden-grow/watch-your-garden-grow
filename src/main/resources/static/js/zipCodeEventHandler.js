const zipCodeSubmitButton = document.querySelector('#zipCodeSubmitButton');
zipCodeSubmitButton.addEventListener('click', function(event){
	event.preventDefault();
	const passedZipCode = zipCodeSubmitButton.parentElement.parentElement.querySelector('input').value;
	passedZipCode
	const instructions = document.querySelector('.hardinessZone')
	instructions.style.display = 'none'
	const sectionForAllPlantsForHardinessZone = document.querySelector('.sectionForAllPlantsForHardinessZone')
	sectionForAllPlantsForHardinessZone.style.display = 'grid'
	const openingImage = document.querySelector('#welcomeToPageImage')
	openingImage.style.display = 'none'
	xhr.open('GET', '/plants/zipcode/'+ passedZipCode, true);
	xhr.send();
});