export function toggleIsAdding() {
   return { type: 'TOGGLE_IS_ADDING' };
}
export function addWord(en, vi) {
   return {
      type: 'ADD_WORD',
      en,
      vi
   };
}

export const toggleMemorized = id => ({
   type: 'TOGGLE_MEMORIZED',
   id
});

export const toggleShow = id => ({
   type: 'TOGGLE_SHOW',
   id
});

export function showAll() {
   return { type: 'FILTER_SHOW_ALL' };
}
export function showMemorized() {
   return { type: 'FILTER_MEMORIZED' };
}
export function showNeedPractice() {
   return { type: 'FILTER_NEED_PRACTICE' };
}
