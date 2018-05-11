function csvDownload(url) {
    console.log(url);
    let JSONData = $.getJSON(url, function(data) {
        console.log(data);
        let items = [...data];
        console.log(items);
        data.forEach(el => delete el.user);
        const replacer = (key, value) => value === null ? '' : value; // specify how you want to handle null values here
        const header = Object.keys(items[0]);
        let csv = items.map(row => header.map(fieldName => JSON.stringify(row[fieldName], replacer)).join(','));
        csv.unshift(header.join(','));
        csv = csv.join('\r\n');

        //Download the file as CSV
        let downloadLink = document.createElement("a");
        let blob = new Blob(["\ufeff", csv]);
        let url = URL.createObjectURL(blob);
        downloadLink.href = url;
        downloadLink.download = "allApps.csv";  //Name the file here
        document.body.appendChild(downloadLink);
        downloadLink.click();
        document.body.removeChild(downloadLink);
    });
}
