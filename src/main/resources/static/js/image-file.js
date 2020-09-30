const client = filestack.init(FILESTACK_KEY);

const options = {
    onUploadDone: saveLocation
};
client.picker(options).open();

function saveLocation(resp){
    console.log(resp);
    // do some error handling and such here like fileError > filesuploaded[0]
    const photo = resp.filesUploaded[0];
    document.getElementById("imageUpload").value = photo.handle;

    document.getElementById("imagePreview").src = "https://cdn.filestackcontent.com/" + photo.handle;
}