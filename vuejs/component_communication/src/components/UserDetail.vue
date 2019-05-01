<template>
  <div class="component">
    <h3>You may view the User Details here</h3>
    <p>Many Details</p>
    <p>User Name: {{ switchName() }}</p>
    <p>User Age: {{ userAge }}</p>
    <button @click="resetName">Reset name</button>

  </div>
</template>

<script>
import { eventBus } from '../main';
export default {
  props: {
    myName: {
      type: String,
      default: "Dog"
    },
    userAge: Number
  },
  methods: {
    switchName() {
      return this.myName
        .split("")
        .reverse()
        .join(" ");
    },
    resetName() {
      // this.myName = 'Max'
      this.$emit('onNameReset')
    },

    
  },
  created() {
      eventBus.$on('onAgeChange', (age) => {
        console.log(age)
        this.userAge = age
      })
  },
};
</script>

<style scoped>
div {
  background-color: lightcoral;
}
</style>
