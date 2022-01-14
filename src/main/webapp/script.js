
function createForm(idInt) {
    let id = idInt;
    let id2 = "2_" + id;
    let id3 = "3_" + id;
    let id4 = "4_" + id;


    let th1 = document.getElementById(id2);
    th1.remove();
    let th2 = document.getElementById(id3);
    // let idValue = th2.textContent;
    th2.remove();
    let th3 = document.getElementById(id4);
    // let nameValue = th3.textContent;
    th3.remove();

    let form = document.createElement("form");
    form.setAttribute("enctype", "multipart/form-data");
    form.setAttribute("method", "get");
    form.setAttribute("action", "/projekt/edytujStatus");

    let inputId = document.createElement("input");
    inputId.setAttribute("type", "hidden");
    inputId.setAttribute("name", "id_status");
    inputId.setAttribute("value", id);
    inputId.setAttribute("id", "inputId");

    let inputName = document.createElement("input");
    inputName.setAttribute("type", "text");
    inputName.setAttribute("name", "title");
    inputName.setAttribute("placeholder", "Podaj nową nazwę");
    inputName.style.marginLeft = "15px";
    inputName.style.marginRight = "10px";
    inputName.style.marginTop = "4px";

    let button = document.createElement("button");
    button.innerHTML = 'Zaktualizuj';
    button.style.cssFloat = 'left';
    button.style.width = '70px';
    button.style.height = '30px';
    button.style.backgroundColor = 'lightgreen';
    button.setAttribute("id", "button");

    // let row_1 = document.createElement('tr');
    let heading_1 = document.createElement('th');
    heading_1.setAttribute("id", "one");
    // heading_1.innerHTML += "<a href=/projekty/usuńStatus?id_status='"+id+"'> Usuń / </a>";
    // heading_1.innerHTML = "Anuluj";
    let heading_2 = document.createElement('th');
    heading_2.setAttribute("id", "two");
    let heading_3 = document.createElement('th');
    heading_3.setAttribute("id", "three");

    form.appendChild(inputName);
    form.appendChild(inputId);
    form.appendChild(button);

    let tr = document.getElementById(id);
    heading_1.appendChild(form);
    tr.appendChild(heading_1);
    tr.appendChild(heading_3);


    let buttonById = document.getElementById("button");
    buttonById.onclick = function () {
        form.submit();
    };


}