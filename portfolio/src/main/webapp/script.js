// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomFact() {
  const facts =
      ['I was born and raised in San Juan, Puerto Rico.', 'My father and his family are from Cuba.', 'I love sushi.', 'I have 6 cats and 2 dogs back home.', 'My favorite book is called "The Song of Achilles."', 'My favorite movies are Hereditay and Midsommar.'];

  // Pick a random greeting.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factsContainer = document.getElementById('facts-container');
  factsContainer.innerText = fact;
}

console.log(getRndString(1, 3))
/** Fetches stats from the server and adds them to the page. */
async function getStrings() {
  const responseFromServer = await fetch('/string');
  // The json() function returns an object that contains fields that we can
  // reference to create HTML.
  const strings = await responseFromServer.json();

  const stringsListElement = document.getElementById('string-container');
  stringsListElement.innerHTML = '';

  stringsListElement.appendChild(
      createListElement(strings[Math.floor(Math.random() * strings.length)]));
}

/** Creates an <li> element containing text. */
function createListElement(text) {
  const liElement = document.createElement('p');
  liElement.innerText = text;
  return liElement;
}

function requestTranslation() {
    const texts = document.getElementsByClassName('filler');
    const languageCode = document.getElementById('language').value;
    const results = document.getElementsByClassName('result');

    for (i = 0; i < texts.length; i++) {
        const text = texts[i].innerText;
        const resultContainer = results[i];
        resultContainer.innerText = 'Loading...';

        const params = new URLSearchParams();
        params.append('text', text);
        params.append('languageCode', languageCode);

        fetch('/translate', {
            method: 'POST',
            body: params
            }).then(response => response.text())
            .then((translatedMessage) => {
            resultContainer.innerText = translatedMessage;
            });
        }
        
    }