
$(document).ready(function() {
   // on ready
});

async function logearUsuario(){

    let data = {};
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    const request = await fetch ('api/login' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });
    let response = await request.text();

    if(response != "fail"){
        localStorage.token = response;
        localStorage.email = data.email;
        window.location.href = 'home.html'
    }else{
        alert("Email o contrasenia incorrecta");
    }
}