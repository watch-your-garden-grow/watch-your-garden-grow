const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {

	if(xhr.readyState === 4 && xhr.status === 404){
		const notFoundRes = JSON.parse(xhr.responseText);
		console.log(notFoundRes);
		window.location ="http://localhost:8080"+notFoundRes.path;

	}
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);

		const plantImageContainer = document.getElementById('plantImageContainer');

		let modal = document.querySelector('.modal');

		function appendPlantLiToPlantContainer(plantObject){
			const plantLi = createElementNoText('li')
			plantLi.className = "plantListItem";
			appendElement(plantImageContainer, plantLi)
			const plantImage = createElement('img')
			plantImage.src = plantObject.image;
			plantImage.alt = plantObject.name;
			const plantLink = createElement('a')
			plantLink.innerText = plantObject.name;
			plantLink.className = 'plantLinks'

			plantImage.addEventListener('click', function(event){
				
				event.preventDefault();
				modal.style.display = "block";
				const modalBoxContent = document.querySelector('.modal-content')
				const plantDescription = document.querySelector('.plantDescription')
				const plantName = document.querySelector('.plantName')
				plantDescription.innerText = plantObject.description
				const modalImageContainer = document.querySelector('.modalImage')
				modalImageContainer.alt = plantObject.name
				modalImageContainer.src = plantObject.image
				plantName.innerText = plantObject.name

				const modalBoxAddToPlantButton = document.getElementById('modalBoxAddToPlantButton')
				modalBoxAddToPlantButton.onclick = () => addPlantToPlan(plantObject.id)

			});

			appendElement(plantLi, plantLink)
			appendElement(plantLink, plantImage)
			const addToPlanButton = createElement("BUTTON")
			addToPlanButton.className = "addToPlanButton"
			addToPlanButton.innerText = "Add To Plan";
			appendElement(plantLi, addToPlanButton)

			const removeFromPlanButton = createElement("BUTTON")
			removeFromPlanButton.className = "toggleButtonClass removeFromPlanButton"
			removeFromPlanButton.innerText = "Remove From Plan";
			appendElement(plantLi, removeFromPlanButton)


			addToPlanButton.addEventListener('click', event => {
				addPlantToPlan(plantObject.id)
				toggleClass(addToPlanButton, "toggleButtonClass")
				toggleClass(removeFromPlanButton, "toggleButtonClass")
			})

			removeFromPlanButton.addEventListener('click', event => {
				removePlantFromPlan(plantObject.id)
				toggleClass(removeFromPlanButton, "toggleButtonClass")
				toggleClass(addToPlanButton, "toggleButtonClass")
			})

			// console.log("after appending" + plantObject.name)

			

			return plantLi
		}

		const modalClose = document.querySelector('.close')
		modalClose.addEventListener('click', function() {
			modal.style.display = 'none';
		});

		document.addEventListener('keydown', event=>{
			if (event.key === 'Escape' || event.keyCode === 27){
				modal.style.display = 'none';
			}
		});

		const ignore = document.querySelector('.modal-content')
		modal.addEventListener('click', function(){
			const target = event.target;
			if(!(target===ignore || ignore.contains(target))){
				modal.style.display = 'none';
			}
		});

		function createElementNoText(elem){
			const newElem = document.createElement(elem)
			return newElem
		}
		function createElementNoText(elem){
			const newElem = document.createElement(elem)
			return newElem
		}
		function createElement(elem, textValue){
			const newElem = document.createElement(elem)
			newElem.innerText = textValue
			return newElem
		}
		
		function removeLi(parent, child){
			parent.removeChild(child);
		}			
		
		function appendElement(parent, child){
			parent.appendChild(child)
		}

		function toggleClass(element, className) {
			element.classList.toggle(className)
		}
		
		const plantListItems = Array.from(document.querySelectorAll('.plantListItem'))
		.forEach(Li=>removeLi(plantImageContainer, Li));

		for (let plant of res){
			appendPlantLiToPlantContainer(plant);
		}
	}
}

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

const planRedirect = document.querySelector('#planReportLink');
planRedirect.addEventListener('click', function(event){
	const passedZipCode = zipCodeSubmitButton.parentElement.parentElement.querySelector('input').value;
	window.open("http://localhost:8080/report/plantplan/1/zipcode/" + passedZipCode, '_blank');
});

// const redoPlanLink = document.querySelector('#redoPlanLink');
// redoPlanLink.addEventListener('click', function(event){
// 	// event.preventDefault();
	
// 	xhr.open('DELETE', 'http://localhost:8080/plantplan/1', true);
// 	xhr.send();
// });