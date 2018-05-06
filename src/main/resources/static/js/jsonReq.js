'use strict';
function req(url) {
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );
}

const buildHtml = data => {
    let newHtml = '';
    data.forEach(el => newHtml += `<a href="/complete#${el.id}">${el.aFirstName} ${el.aLastName}</a><br/>`);
    return $('#apps').append(newHtml);
};