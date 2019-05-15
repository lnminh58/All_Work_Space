<template>
  <nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="navbar-nav">
      <router-link to="/" tag="li" class="nav-item" active-class="active" exact="">
        <a class="nav-link">Home</a>
      </router-link>

      <router-link to="/user/1" tag="li" class="nav-item" active-class="active">
        <a class="nav-link">user1</a>
      </router-link>

      <router-link to="/user/2" tag="li" class="nav-item" active-class="active">
        <a class="nav-link">user2</a>
      </router-link>
    </ul>
  </nav>
</template>
