'use strict';
function req(url) {
    let heading = '';
    if(url === '/complete') {
        heading = `<h4>Complete Applications</h4>`;
    } else {
        heading = `<h4>Pending Applications</h4>`;
    }
    fetch(url)
        .then((response) => response.json()
            .then((jsonData) => buildHtml(jsonData))
        );
    const buildHtml = data => {
        let newHtml = '';
        data.forEach(el => newHtml +=
            `<a href="/show=${el.id}">${el.aFirstName} ${el.aLastName}</a><br/>`);
        return $('#apps').html(heading + newHtml);
    };
}


// function preq(url) {
//     fetch(url)
//         .then((response) => response.json()
//             .then((jsonData) => buildHtml(jsonData))
//         );
//     const buildHtml = data => {
//         let heading = `<h4>Pending Applications</h4>`;
//         let newHtml = '';
//         data.forEach(el =>
//             newHtml += `<a href="/pending#${el.id}">${el.aFirstName} ${el.aLastName}</a><br/>`);
//         return $('#apps').html(heading + newHtml);
//     };
// }