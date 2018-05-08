'use strict';
function req(url) {
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );

    const buildHtml = data => {
        let heading = `<h4>Complete Applications</h4>`;
        let newHtml = '';
        data.forEach(el => newHtml +=
            `<a href="/complete#${el.id}">${el.aFirstName} ${el.aLastName}</a><br/>`);
        return $('#apps').append(heading + newHtml);
    };
}


function preq(url) {
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );
    const buildHtml = data => {
        let heading = `<h4>Pending Applications</h4>`;
        let newHtml = '';
        data.forEach(el =>
            newHtml += `<a href="/pending#${el.id}">${el.aFirstName} ${el.aLastName}</a><br/>`);
        return $('#apps').append(heading + newHtml);
    };
}

