def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'b8306909-6521-4e9a-9825-69e4c47f15aa', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t bhaveshmuleva/java-demo-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push nanajanashia/java-demo-app:jma-2.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
