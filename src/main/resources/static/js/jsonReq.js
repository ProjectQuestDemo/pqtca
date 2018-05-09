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
        let newHtml = '';
        data.forEach(el => newHtml +=
            `<button type="button" onclick="showApp('/show=${el.id}')">${el.aFirstName} ${el.aLastName}</button><br/>`);
        return $('#apps').html(heading + newHtml);
    };
}


const showNotification = () => {
    fetch('/pending')
        .then((response) => response.json()
            .then((jsonData) => update(jsonData))
        );
    const update = data => {
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
        let newHtml = '';
        for (let prop in data) {
            newHtml += `<div>
                            <label>${prop.slice(1)}: </label>
                            <input value="${data[prop]}"/>
                        </div>`;
        }
        return $('#apps').html(newHtml);
    };
};