document.addEventListener(
	'DOMContentLoaded', function(){
		document.getElementById('loadPets').addEventListener('click', function(){
			loadPets();
		})
	const petForm = document.getElementById('petForm');
	petForm.addEventListener('submit', function(event) {
		event.preventDefault();
		savePet();
	});
});

function loadPets(){
	fetch('http://localhost:8080/api/pets')
	.then(response => {
		if(!response.ok){
			throw new Error('Network response was not ok');
		}
		return response.json();
	})
	.then(pets => {
		displayPets(pets);
	})
	.catch(error => {
		console.error('Error loading pets', error);
	});
}

function displayPets(pets){
	const petsContainer = document.getElementById('petsContainer');
	petsContainer.innerHTML = '';
	
	pets.forEach(function(pet){
		const petDiv = document.createElement('div');
		petDiv.textContent = `${pet.name} - ${pet.breed} - ${pet.price}`;
		petsContainer.appendChild(petDiv);
		
	});
}

function savePet(){
	const petForm = document.getElementById('petForm');
	const formData = new FormData(petForm);
	
	const pet = {
		name : formData.get('name'),
		breed: formData.get('breed'),
		price: formData.get('price')
	};
	
	const petId = formData.get('id');
	const url = petId ? `http://localhost:8080/api/pets/${petId}` : `http://localhost:8080/api/pets`;

	fetch(url, {
		method: petId ? 'PUT' : 'POST',
		headers: {
			'Content-Type': 'application/json', 
		},
		body: JSON.stringify(pet),
	})
	.then(response => {
		if(!response.ok){
			throw new Error('Network response was not ok');
		}
		return reposne.json();
	})
	.then(savedPet => {
		console.log('Pet saved : ', savedPet);
		loadPets();
	})
	.catch(error => {
		console.error('Error saving pet : ', error);
	})
}