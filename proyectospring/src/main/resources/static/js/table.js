
$(document).ready(function() {
    getCryptos();
  $('#crypto-table').DataTable();
});
async function getCryptos(){

    const request = await fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=20&page=1&sparkline=false', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    const cryptoList = await request.json();
    console.log(cryptoList);

    let htmlList = '';
    for(let crypto of cryptoList){

        let high_percentage = '<th class="column-date green column-date-24hs" id="change-24hs"><i class="ri-arrow-right-up-line date-arrow-high"></i>' + crypto.price_change_percentage_24h + '%' + '</th></tr>';
        let low_percentage = '<th class="column-date red column-date-24hs" id="change-24hs"><i class="ri-arrow-left-down-line date-arrow-low"></i>' + crypto.price_change_percentage_24h + '%' + '</th></tr>';

        let link = '<th class="column-date column-date-hover"><a onclick="getCard(bitcoin)" class="column-date-link" id="date-link">' + crypto.name +'<a/></th>';

        let cryptoHtml = '<tr><th class="column-date column-date-hover"><a onclick="getCard(bitcoin)" href="card.html" class="column-date-link" id="date-link"><img class="column-date-logo" src="' + crypto.image + '"><img/><a/></th>' + link + '<th class="column-date">' + '$ ' + crypto.current_price + '</th>';

        if(crypto.price_change_percentage_24h > 0){
            cryptoHtml += high_percentage;
        }else if(crypto.price_change_percentage_24h < 0){
            cryptoHtml += low_percentage;
        }

        htmlList += cryptoHtml;
    }

    document.querySelector('#crypto-table tbody').outerHTML = htmlList;
}

//CASI jajajajaj
async function getCard(name){

    const request = await fetch('api/cryptos/{name}', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    })

    const crypto = await request.json();

    let cardHtml = '';
    for(data of crypto){
        let dataHtml = '<img src="'+data.logo+'" class="card-logo" alt="error"><h3 class="card-symbol">'+data.simbolo+'</h3><h4 class="card-name">'+data.nombre+'</h4><p class="card-description">'+data.descripcion+'</p>'
    }

    document.querySelector('#card div').outerHTML = dataHtml;
    window.location.href = "card.html";
}

