pipeline {
    agent any
    
    tools {
        maven 'Maven 3.6.1'
        jdk 'jdk11'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                cd login
                mvn clean
                mvn package -Dmaven.test.skip=true
                mvn dockerfile:build
                cd ../play
                mvn clean
                mvn package -Dmaven.test.skip=true
                mvn dockerfile:build
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                cd login
                mvn test
                cd ../play
                mvn test
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying..'
            }
        }
    }
}
