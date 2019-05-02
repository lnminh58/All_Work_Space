<template>
  <div id="app" class="container">
    <app-header
      :quoteCount="quotes.length"
      :maxQuotes="maxQuotes"
    ></app-header>
    <new-quote @onNewQuoteSubmit="onNewQuoteSubmit"></new-quote>
    <quotes-grid
      :quotes="quotes"
      @onQuoteDelete="onQuoteDelete"
    ></quotes-grid>
    <div class="row">
      <div class="col-sm-12 text-center my-3">
        <div class="alert alert-info">
          info: click on a quote to delete it
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import QuotesGrid from './components/QuotesGrid';
import NewQuote from './components/NewQuote';
import Header from './components/Header';
export default {
  data() {
    return {
      quotes: [
        'Just a Quote to see something'
      ],
      maxQuotes: 10
    }
  },
  methods: {
    onNewQuoteSubmit(data) {
      if(this.quotes.length === this.maxQuotes) return alert('Please delete fisrt')
      if (data.toString().trim()) this.quotes.push(data)
    },
    onQuoteDelete(index) {
      this.quotes.splice(index, 1)
    }
  },
  components: {
    QuotesGrid,
    NewQuote,
    appHeader: Header
  }
}
</script>

<style>

</style>
