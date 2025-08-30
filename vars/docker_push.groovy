def call(String projectName, String imageTag, String dockerHubUser) {
    withCredentials([usernamePassword(
        credentialsId: "dockerhub-creds",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
    }
}
