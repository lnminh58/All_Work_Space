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

export function saveWork(title, detail, id = null) {
   return {
      type: 'SAVE',
      title,
      detail,
      id
   };
}

export function fillUpForm(title, detail, id = null) {
   return {
      type: 'FILLUP',
      title,
      detail,
      id
   };
}

export function goToForm() {
   return {
      type: 'GO_FORM'
   };
}

export function goToHome() {
   return {
      type: 'GO_HOME'
   };
}
