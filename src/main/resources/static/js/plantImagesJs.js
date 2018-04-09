const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {


	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);


		const plantImageContainer = document.getElementById('plantImageContainer');

		// function appendToModalBox(plantObject){
			
		// }

		function appendPlantLiToPlantContainer(plantObject){
			const plantLi = createElementNoText('li')
			plantLi.className = "plantListItem";
			appendElement(plantImageContainer, plantLi)
			const plantImage = createElement('img')
			plantImage.src = plantObject.image;
			plantImage.alt = plantObject.name;
			const plantLink = createElement('a')

			// plantLink.href = 'plant/'+plantObject.id;
			plantLink.innerText = plantObject.name;
			plantLink.className = 'plantLinks'

			// const allImagesForModal = querySelectorAll('modal')
			plantImage.addEventListener('click', function(event){
				event.preventDefault();
				let modal = document.querySelector('.modal');
				modal.style.display = "block";
				// const modalBox = document.getElementById('modalBoxContent')
				appendElement(modal, plantObject.name)
				});

			appendElement(plantLi, plantLink)
			appendElement(plantLink, plantImage)
			const addToPlanButton = createElement("BUTTON")
			addToPlanButton.className = "addToPlanButton"
			addToPlanButton.innerText = "Add To Plan";
			appendElement(plantLi, addToPlanButton)
			
			return plantLi
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
	xhr.open('GET', '/plants/zipcode/'+ passedZipCode, true);
	xhr.send();
});
