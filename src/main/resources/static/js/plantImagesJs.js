const plantImageContainer = document.getElementById('plantImageContainer');
const redoPlanLink = document.querySelector('#redoPlanLink');
const planRedirect = document.querySelector('#planReportLink');

const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {

	if(xhr.readyState === 4 && xhr.status === 404){
		const notFoundRes = JSON.parse(xhr.responseText);
		console.log(notFoundRes);
		window.location ="http://localhost:8080"+notFoundRes.path;

	}
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);


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

			plantLink.addEventListener('click', function(event){
				
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

			return plantLi
		}

		
		const appendReportCardToPlantContainer = () => {
			const plantLi = createElementNoText('li')
			plantLi.className = "plantListItem";
			appendElement(plantImageContainer, plantLi)
			const plantImage = createElement('img')
			plantImage.src = "/images/styleImages/reportthumb.png";
			plantImage.alt = "";
			const plantLink = createElement('a')
			plantLink.innerText = "Planting Report";
			plantLink.className = 'plantLinks'
				
				appendElement(plantLi, plantLink)
				appendElement(plantLink, plantImage)
				const addToPlanButton = createElement("BUTTON")
				addToPlanButton.className = "addToPlanButton"
				addToPlanButton.innerText = "Create Report";
				appendElement(plantLi, addToPlanButton)
				addToPlanButton.addEventListener('click', handlePlanRedirect);
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

		// function createElementNoText(elem){
		// 	const newElem = document.createElement(elem)
		// 	return newElem
		// }
	
		function createElement(elem, textValue){
			const newElem = document.createElement(elem)
			newElem.innerText = textValue
			return newElem
		}
		
		function removeLi(parent, child){
			parent.removeChild(child);
		}			
		
		// function appendElement(parent, child){
		// 	parent.appendChild(child)
		// }

		function toggleClass(element, className) {
			element.classList.toggle(className)
		}
		
		const plantListItems = Array.from(document.querySelectorAll('.plantListItem'))
		.forEach(Li=>removeLi(plantImageContainer, Li));

		
		for (let plant of res){
			appendPlantLiToPlantContainer(plant);
		}
		appendReportCardToPlantContainer();

	}
}
function createElementNoText(elem){
			const newElem = document.createElement(elem)
			return newElem
		}

function appendElement(parent, child){
			parent.appendChild(child)
		}

function handlePlanRedirect() {
	const passedZipCode = zipCodeSubmitButton.parentElement.parentElement.querySelector('input').value;
	window.open("http://localhost:8080/report/plantplan/" + planIdent + "/zipcode/" + passedZipCode, '_blank');
}

planRedirect.addEventListener('click', handlePlanRedirect);


redoPlanLink.addEventListener('click', (event) => {
	event.preventDefault();
	planIdent = -1;
	while (plantImageContainer.firstChild) {
		plantImageContainer.removeChild(plantImageContainer.firstChild);
	}
	console.log("redo called")
	handleZipCodeinput();
});
