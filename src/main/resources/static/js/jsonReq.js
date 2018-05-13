'use strict';

function req(url) {
    let heading = '';
    if (url === '/complete') {
        heading = "<h3 class='form-header'>Complete Applications</h3>";
    } else {
        heading = "<h3 class='form-header'>Pending Applications</h3>";
    }
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => {
                delete jsonData[-1];
                buildHtml(jsonData);
            })
        );


    const buildHtml = data => {
        delete data[-1];
        let newHtml = '';
        data.forEach(el => newHtml +=

            `<a href="/show=${el.id}">${el.aFirstName} ${el.aLastName}</a>`);

        return $('.content').html(heading + newHtml);
    };
}


const showNotification = () => {
    fetch('/pending')
        .then((response) => response.json()
            .then((jsonData) => update(jsonData))
        );
    const update = data => {
        delete data[-1];
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

        delete data[-1];
        let id;
        let newHtml = '';

        newHtml += `<div class="individual app">`;
        for (let prop in data) {
            newHtml += `<p class="app-review">${data[prop]}</p>`;
        }
        id = data.id;
        newHtml += `<input type="button" class="color-change" name="export" onclick="csvDownload(url)" value="Export"/></form> </div>`;

        return $('#apps').html(newHtml);
    };
};

