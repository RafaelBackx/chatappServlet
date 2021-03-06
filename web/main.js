let xhr = new XMLHttpRequest();
let dropdown = document.getElementById("status");
dropdown.addEventListener("click",setstatus,false);
let inputting = false;
let addbutton = document.getElementById('addfriend');
addbutton.addEventListener('click',addfriend,false);
let timeoutid;
getFriendlist();



function setstatus(){
    let status = dropdown.options[dropdown.selectedIndex].value;
    console.log(status);
    if (status === "other") {
        let div = document.createElement('div');
        let input = document.createElement('input');
        let submit = document.createElement('button');
        submit.innerText = "submit";
        div.appendChild(input);
        div.appendChild(submit);
        if (!inputting){
            document.body.appendChild(div);
            inputting = true;
        }
        submit.addEventListener('click',function () {
            if (input.value !== ''){
                status = input.value;
                console.log('submitting: ' + status);
                document.body.removeChild(div);
                inputting = false;
                change(status);
            }
        },false)
    }else{
        change(status);
    }
}
function change(status){
    xhr.open('POST', 'Controller?command=Change&status='+status);
    xhr.onreadystatechange = update;
    xhr.send(null);
}

function update(){
    if (xhr.status === 200){
        if (xhr.readyState === 4){
            let text = xhr.responseText;
            console.log(text);
            document.querySelector('h1').innerText = text;
        }
    }
}

function getFriendlist(){
    console.log("refresh");
    xhr.open('GET','Controller?command=GetFriends');
    xhr.onreadystatechange = showFriends;
    xhr.send(null);
}

function showFriends(){
    if (xhr.status === 200){
        if (xhr.readyState === 4){
            // console.log(navigator.userAgent);
            clearTable();
            console.log(xhr.responseText);
            let text = JSON.parse(xhr.responseText);
            console.log(text);
            let table = document.getElementById('friends');
            let teller = 1;
            for (let person in text){
                console.log(person);
                let tr = document.createElement('tr');
                let tdname = document.createElement('td');
                tdname.innerText = text[person].name;
                let tdstatus = document.createElement('td');
                tdstatus.innerText = text[person].statusname;
                let tdnr = document.createElement('td');
                tdnr.innerText = teller;
                let chatButton = document.createElement("a");
                chatButton.href = "Controller?command=GoToChat&friend="+text[person].name;
                chatButton.innerText= "chat";
                tr.appendChild(tdnr);
                tr.appendChild(tdname);
                tr.appendChild(tdstatus);
                tr.append(chatButton);
                tr.className = 'friendlist';
                table.appendChild(tr);
                teller++;
            }
            timeoutid = setTimeout(getFriendlist,20000);
        }
    }
}

function clearTable(){
    let friends = document.querySelectorAll('.friendlist');
    let table = document.getElementById('friends');
    for (let i=0;i<friends.length;i++){
        table.removeChild(friends[i]);
    }
 }

 function addfriend(){
     clearTimeout(timeoutid);
     xhr.open('POST','Controller?command=AddFriend&name='+document.getElementById('name').value);
     xhr.onreadystatechange = showFriends;
     xhr.send(null);
 }