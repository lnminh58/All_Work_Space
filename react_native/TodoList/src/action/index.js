export function changeWorkStatus(id) {
   return {
      type: 'TOGGLE_IS_DONE',
      id
   };
}

export function removeWork(id) {
   return {
      type: 'REMOVE',
      id
   };
}

export function changeToTab(tabId) {
   return {
      type: 'CHANGE_TAB',
      tabId
   };
}

export function addWork(title, detail) {
   return {
      type: 'ADD',
      title,
      detail
   };
}


export function fillUpForm(title, detail) {
   return {
      type: 'FILLUP',
      title,
      detail
   };
}
