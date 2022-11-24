node {
    stage('Say Hi') {
        echo 'hi!'
    }

    stage('Checkout') {
        checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: '08f6c9f0-1cde-49ff-8399-29008afb64d2', url: 'https://github.com/BogdanShvetss/ci/']]])
    }

    stage('running tests') {
        bat "mvn -Dmaven.test.failure.ignore=true -Dtest=api.*Test test"
    }

    stage('allure report') {
        allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
    }
}