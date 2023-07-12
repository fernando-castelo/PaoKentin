const overlay = document.querySelector(".overlay");
document.querySelector('#botao-cadastro').addEventListener('click',()=>{
    let modal = document.querySelector('.modal-confirm');
    let fade = document.querySelector('.fade-modal');
    modal.style.display='flex';
    fade.style.display='flex';
})

document.querySelector('#cancelar').addEventListener('click', ()=>{
    let modal = document.querySelector('.modal-confirm');
    let fade = document.querySelector('.fade-modal');
    modal.style.display='none';
    fade.style.display='none';
})