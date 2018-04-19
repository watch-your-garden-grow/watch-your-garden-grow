const zipCodeSubmitButton = document.querySelector('#zipCodeSubmitButton');
zipCodeSubmitButton.addEventListener('click', function (event) {
	event.preventDefault();
	handleZipCodeinput();
});

const handleZipCodeinput = () => {
	const passedZipCode = zipCodeSubmitButton.parentElement.parentElement.querySelector('input').value;
	const instructions = document.querySelector('.hardinessZone')
	instructions.style.display = 'none'
	const sectionForAllPlantsForHardinessZone = document.querySelector('.sectionForAllPlantsForHardinessZone')
	sectionForAllPlantsForHardinessZone.style.display = 'grid'

	xhr.open('GET', '/plants/zipcode/' + passedZipCode, true);
	xhr.send();
}