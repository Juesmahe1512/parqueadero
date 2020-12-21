pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Mac'
    }

    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
        disableConcurrentBuilds()
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    tools {
            jdk 'JDK8_Mac'
        }

    //Aquí comienzan los “items” del Pipeline
    stages{

        stage('Checkout') {
            steps{
                echo "------------>Checkout<------------"
                sh './gradlew clean'
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [],
                    gitTool: 'Default',
                    submoduleCfg: [],
                    userRemoteConfigs: [[
                    credentialsId: 'GitHub_Juesmahe1512',
                    url:'https://github.com/Juesmahe1512/parqueadero'
                    ]]
                ])
            }
        }

        stage('Build') {
                     steps {
                     echo "------------>Build<------------"
                     sh './gradlew build -x test'
                     }
        }

        stage('Unit Tests') {
                    steps{
                        echo "------------>Unit Tests<------------"
                        sh './gradlew test'
                    }
        }

        stage('Static Code Analysis') {
                    steps{
                        echo '------------>Análisis de código estático<------------'
                        withSonarQubeEnv('Sonar') {
                            sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -project.settings=sonar-project.properties"
                        }
                    }
        }

    }

    post {
        always {
            echo 'This will always run'
        }
        success {
            echo 'This will run only if successful'
            junit 'build/test-results/test/*.xml'
        }
        failure {
            echo 'This will run only if failed'
            mail (to: 'juan.mazo@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}

