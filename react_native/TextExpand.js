import React, { Component, PropTypes } from 'react';

import { View, Text, Dimensions } from 'react-native';

import S from 'string';

import { fontMaker } from '../theme/common';

const styles = {
  descriptionStyle: {
    ...fontMaker({ weight: '300', family: 'Montserrat' })
  },
  readMoreStyle: {
    ...fontMaker({ weight: '300', family: 'Montserrat' }),
    color: '#079c90'
  }
};

const fullWidth = Dimensions.get('window').width;

const deltaWidth = 70;

export default class TextExpand extends Component {
  static propTypes = {
    content: PropTypes.string.isRequired,
    viewMoreText: PropTypes.string,
    viewLessText: PropTypes.string,
    textStyle: PropTypes.object,
    readMoreStyle: PropTypes.object,
    numberOfLines: PropTypes.number,
    containerStyle: PropTypes.object,
    resetToShowLess: PropTypes.bool,
    onPressReadmore: PropTypes.func
  };

  static defaultProps = {
    content: '',
    viewMoreText: 'Read more',
    viewLessText: 'Show less',
    numberOfLines: 4,
    textStyle: {
      fontSize: 14
    }
  };

  constructor(props) {
    super(props);

    const { content } = this.props;
    this.state = {
      descriptionText: content,
      isShowMore: false,
      shouldShowReadMore: false
    };
  }

  componentDidMount() {
    if (this.isShouldShowReadMore(this.props)) {
      this.truncateTextContent(this.props.content);
    }
  }

  componentWillReceiveProps(nextProps) {
    const { content } = this.props;
    this.setState({ descriptionText: nextProps.content });

    if (this.isShouldShowReadMore(nextProps)) {
      this.truncateTextContent(nextProps.content);
    }

    if (nextProps.resetToShowLess) {
      this.setState({isShowMore: false});
    }
  }

  truncateTextContent(content) {
    const numberOfChars = this.getNumberOfChars();
    const descriptionText = S(content).truncate(numberOfChars).s;
    this.setState({ shouldShowReadMore: true, descriptionText: descriptionText });
  }

  getNumberOfChars() {
    const { textStyle, numberOfLines } = this.props;
    const widthAChar = textStyle.fontSize / 2;
    const numberOfChars = ((fullWidth - deltaWidth) * numberOfLines) / widthAChar;
    return numberOfChars;
  }

  isShouldShowReadMore(dataObj) {
    const { textStyle, numberOfLines, content } = dataObj;
    const widthAChar = textStyle.fontSize / 2;
    const widthOfText = content.length * widthAChar;
    if (widthOfText > ((fullWidth - deltaWidth) * numberOfLines)) {
      return true;
    }
    if (this.state.shouldShowReadMore) {
      this.setState({ shouldShowReadMore: false });
    }
    return false;
  }

  toggleDescriptionExpand() {
    const { content, onPressReadmore } = this.props;

    if (this.state.isShowMore) {
      this.truncateTextContent(content);
    } else {
      this.setState({ descriptionText: content });
      onPressReadmore && onPressReadmore();
    }

    this.setState({ isShowMore: !this.state.isShowMore });
  }

  renderFooter() {
    const {
      viewMoreText,
      viewLessText,
      readMoreStyle
    } = this.props;

    // if viewLessText is '' then do not render show less Text
    if (this.state.isShowMore && !viewLessText) {
      return;
    }

    return (
      <Text
        style={[styles.readMoreStyle, readMoreStyle]}
        onPress={() => this.toggleDescriptionExpand()}>
        {this.state.isShowMore ? ' ' + viewLessText : ' ' + viewMoreText}
      </Text>
    );
  }

  render() {
    const { containerStyle, textStyle } = this.props;

    return (
      <Text style={[styles.descriptionStyle, textStyle]}>
        { this.state.descriptionText }
        { this.state.shouldShowReadMore && this.renderFooter() }
      </Text>
    );
  }
}
