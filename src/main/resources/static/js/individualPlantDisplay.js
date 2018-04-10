const plantDisplayClick = document.querySelector('.plantLinks'),
	modal = document.querySelector('.modal')

const xhr2 = new XMLHttpRequest()
xhr2.onreadystatechange = function() {
	if(xhr2.readyState === 4 && xhr2.status === 200) {
		const res = xhr2.responseText
		modal.innerHTML = res
	}
}

plantDisplayClick.addEventListener('click', function(event) {
	event.preventDefault();
	let modal = document.querySelector('.modal')
	modal.style.display = 'block'
})