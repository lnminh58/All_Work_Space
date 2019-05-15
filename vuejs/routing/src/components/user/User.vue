<template>
  <div>
    <h1>The User Page</h1>
    <hr>
    <p>loaded: {{ id }}</p>
    <button @click="navigateToHome" class="btn btn-danger">Go To Home</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      id: this.$route.params.id
    }
  },
  watch: {
    '$route'(to,from) {
      this.id = to.params.id
    }
  },
  methods: {
    navigateToHome() {
      this.$router.push({ path: '/' });
    }
  }
};
</script>
