const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {


	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);


		const plantImageContainer = document.getElementById('plantImageContainer');
		// const newPlantListItem = document.getElementById('newPlantListItem');
		// productContainer.innerText = res.name
		console.log(xhr);
		// plantImageContainer.appendChild(newPlantListItem);
		// newPlantListItem.innerText = res.name;

		function appendPlantLiToPlantContainer(plantObject){
			const plantLi = createElement('li', plantObject.name)
			appendElement(plantImageContainer, plantLi)
			appendElement(plantLi, createElement('img', plantObject.image))
			return plantLi
		}
		function createElement(elem, textValue){
			const newElem = document.createElement(elem)
			newElem.innerText = textValue
			return newElem
		}
		function appendElement(parent, child){
			parent.appendChild(child)
		}
		for (let plant of res){
		appendPlantLiToPlantContainer(plant);
		console.log(plant)
		console.log(plant.img)
		console.log(plant.name)
		console.log(plantImageContainer)
		}
	}
}
// xhr.open('GET', '/plants', true)
// xhr.send()

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

// function postPlants(name){
// xhr.open('POST', '/plants/' + name, true)
// xhr.send()
// }