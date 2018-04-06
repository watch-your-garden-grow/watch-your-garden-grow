const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {


	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);


		const plantImageContainer = document.getElementById('plantImageContainer');
	
		console.log(xhr);
		// plantImageContainer.appendChild(newPlantListItem);
		// newPlantListItem.innerText = res.name;

		function appendPlantLiToPlantContainer(plantObject){
			const plantLi = createElement('li', plantObject.name)
			plantLi.className = "plantListItem";
			appendElement(plantImageContainer, plantLi)
			const plantImage = createElement('img')
			plantImage.src = plantObject.image;
			appendElement(plantLi, plantImage)
			// console.log(plantObject.image)
			return plantLi
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
		console.log(plant)
		console.log(plant.img)
		console.log(plant.name)
		console.log(plantImageContainer)
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

// function getPlants() {
// 	xhr.open('GET', '/plants', true)
// 	xhr.send()
// }