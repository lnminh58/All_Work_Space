export const  fruitMixin = {
  data() {
    return {
      fruits: ["Banana", "Mango", "Apple", "Coconut"],
      filterText: ""
    };
  },
  computed: {
    filteredFruits() {
      return this.fruits.filter(element =>
        element.toLowerCase().match(this.filterText.toLowerCase())
      );
    }
  }
};
