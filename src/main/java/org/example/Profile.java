package org.example;

import java.io.*;
import java.net.*;
import com.google.gson.Gson;

public class Profile {
    private String name, bio, login, location;
    private long id;

    public String getNome() {
        return name;
    }

    protected void setNome(String nome) {
        this.name = nome;
    }

    public String getBio() {
        return bio;
    }

    protected void setBio(String bio) {
        this.bio = bio;
    }

    public String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    public String getEndereco() {
        return location;
    }

    protected void setEndereco(String endereco) {
        this.location = endereco;
    }

    public long getId() {
        return id;
    }

    protected void setId(long id) {
        this.id = id;
    }

    public Profile(String login){
        this.login = login;
    }

    public void consumer(){
        try {
            String api = "https://api.github.com/users/"+this.getLogin();
            Gson gson = new Gson();

            URL url = new URL(api);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Profile profile = gson.fromJson(response.toString(), Profile.class);

            setNome(profile.getNome());
            setBio(profile.getBio());
            setEndereco(profile.getEndereco());
            setId(profile.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
