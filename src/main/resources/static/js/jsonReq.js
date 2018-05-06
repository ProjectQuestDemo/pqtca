 function req(url) {
    fetch(url)
        .then((response) => {
            if (response.status === 500) {
                return response.json() // return the result of the inner promise, which is an error
            } else {
                return response.json();
            }
        })
 }