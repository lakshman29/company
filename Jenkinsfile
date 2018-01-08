pipeline {
  agent any
  stages {
    stage('cf version') {
      steps {
        bat 'cf --version'
      }
    }
    stage('error') {
      steps {
        bat 'build'
      }
    }
  }
}