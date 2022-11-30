
async function registrarUsuario(){

    let data = {};
    data.nombre = document.getElementById('txtNombre').value;
    data.apellido = document.getElementById('txtApellido').value;
    data.email = document.getElementById('txtEmail').value;
    data.password = document.getElementById('txtPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;
    email = document.getElementById('txtEmail').value;
    
    if(repeatPassword != data.password){
        alert("las contrasenias no coinciden!")
        return;
    }else if(data.password.length < 6){
        alert("la contrasenia debe contener al menos 6 caracteres");
        return;
    }

    const mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    function tiene_mayusculas(repeatPassword){

        for(i=0;i < repeatPassword.length; i++){
            if(mayusculas.indexOf(repeatPassword.charAt(i),0)!=-1){
             return true;
            }
        }
        alert("No contiene mayusculas");
        return false;
    }

    const arroba = "@";
    function tiene_arroba(email){

        for(i=0;i < email.length; i++){
            if(arroba.indexOf(email.charAt(i),0)!=-1){
             return true;
            }
        }
        alert("El Email introducido no es valido");
        return false;
    }

    if(tiene_mayusculas(repeatPassword) ==  false){
        return;
    }else if(tiene_arroba(email) == false){
        return;
    }

    const request = await fetch ('api/users' , {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    });

    window.location.href = "registerconfirm.html";

}


