import Vue from 'vue';

Vue.filter('to-lowercase', (value) => value.toLowerCase() + ' lowered')
