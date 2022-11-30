
const menuButton = document.getElementById('menu-button');
const menu = document.getElementById('menu');
const menuButtonClose = document.getElementById('menu-button-close');

function desplegarMenu(){
    if(menuButton){
        menuButton.addEventListener('click', () => {
            menu.classList.add('show-menu');
            menuButton.classList.add('display-none');
        })
    }
}

function cerrarMenu(){
    if(menuButton){
        menuButtonClose.addEventListener('click', () => {
            menu.classList.remove('show-menu');
            menuButton.classList.remove('display-none');
        })
    }
}