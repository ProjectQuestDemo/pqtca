'use strict';

function req(url) {
    let heading = '';
    if (url === '/complete') {
        heading = "<h4>Complete Applications</h4>";
    } else {
        heading = "<h4>Pending Applications</h4>";
    }
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );

    const buildHtml = data => {
        delete data.user;
        let newHtml = '';
        data.forEach(el => newHtml +=
            `<button class="color-change" 
                     onclick=showApp("/show=${el.id}")>${el.aFirstName} ${el.aLastName}
            </button>`);
        return $('#apps').html(heading + newHtml);
    };
}


const showNotification = () => {
    fetch('/pending')
        .then((response) => response.json()
            .then((jsonData) => update(jsonData))
        );
    const update = data => {
        delete data.user;
        let count = 0;
        console.log(data);
        count = data.length;
        console.log(count);
        $('#pending').attr('data-badge', count);
        setInterval(data, 1000000);


    }
};
const showApp = url => {
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );
    const buildHtml = data => {

        delete data.user;
        let id;
        let newHtml = '';

        newHtml += `<div class="individual app">`;
        for (let prop in data) {
            newHtml += `<p class="app-review">${data[prop]}</p>`;
        }
        id = data.id;
        newHtml += `<input type="button" class="color-change" name="export" onclick="csvDownload('/show=${data.id}')" value="Export"/></form> </div>`;

        return $('#apps').html(newHtml);
    };
};
