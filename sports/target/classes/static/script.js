const searchBar = document.getElementById('searchBar');
const equipmentCards = document.querySelectorAll('.card');

searchBar.addEventListener('input', () => {
  const query = searchBar.value.toLowerCase();
  equipmentCards.forEach(card => {
    const name = card.querySelector('h3').textContent.toLowerCase();
    card.style.display = name.includes(query) ? 'block' : 'none';
  });
});

function filterCategory(category) {
  equipmentCards.forEach(card => {
    const cardCategory = card.getAttribute('data-category');
    card.style.display = cardCategory === category ? 'block' : 'none';
  });
}