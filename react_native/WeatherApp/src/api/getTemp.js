const URL =
   'https://api.openweathermap.org/data/2.5/find?units=metric&appid=f58237493ebcf50709e535d267ab10a2&q=';

export function getTemp(city) {
   return fetch(URL + city)
      .then(res => res.json())
      .then(data => ({
         city: data.list[0].name,
         temp: data.list[0].main.temp
      }));
}

// getTemp('danang').then(data => console.log(data)).catch(err => console.log(err))
