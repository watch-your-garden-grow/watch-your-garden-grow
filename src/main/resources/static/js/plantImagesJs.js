const xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText)
		const plantImageContainer = document.getElementById('plantImageContainer');
		const newPlantListItem = document.getElementById('newPlantListItem');
		// productContainer.innerText = res.name
		console.log(xhr);
		// plantImageContainer.appendChild(newPlantListItem);
		// newPlantListItem.innerText = res.name;
	}
}

const zipCodeSubmitButton = document.getElementById('zipCodeSubmitButton');
zipCodeSubmitButton.addEventListener('click', function(){
	postPlants(plantImageContainer)
});

function getPlants() {
	xhr.open('GET', '/plants', true)
	xhr.send()
}

function postPlants(name){
xhr.open('POST', '/plants/' + name, true)
xhr.send()
}