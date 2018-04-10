const plantImageContainer = document.querySelector('#plantImageContainer');



xhr.onreadystatechange = function() {


	if (xhr.readyState === 4 && xhr.status === 200){
		const res = JSON.parse(xhr.responseText);
		
		
	const zipCodeSubmitButton = document.getElementById('#zipCodeSubmitButton').addEventListener('click', loadText);	
	function loadText(){
		const xhr = new XMLHttpRequest();
		console.log(xhr);

		xhr.open('GET', '/plants', true);
		xhr.onload = function()
	

		}
	
	}
		xhr.send();
}

	
