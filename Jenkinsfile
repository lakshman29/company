pipeline {
  agent any
  stages {
    stage('clean') {
      steps {
        bat 'clean mvn'
      }
    }
    stage('') {
      steps {
        bat 'build'
      }
    }
  }
}