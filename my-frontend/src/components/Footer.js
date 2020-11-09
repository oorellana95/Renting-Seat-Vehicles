import React from "react";
import { Container, Row, Col } from "reactstrap";

class Footer extends React.Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
    this.state = { random: "https://youtu.be/mL7Gb6rcAAo"}
  }

  render() {
    return (
      <footer className="footer" data-background-color="black">
        <Container>
          <Row>
            <Col lg={4} xs={12}>
              <h4>POM dreams</h4>
            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quasi voluptatem quisquam, labore nesciunt modi officiis?
            <br /><br />
            Dicta necessitatibus neque perferendis aperiam iste sint cum dolor fugiat nisi temporibus aut!
          </Col>

            <Col lg={4} xs={12} className="text-center">
              <h4>Play music</h4>
              <p>Listen the best songs</p>
              <a onClick={this.handleClick.bind(this)}
                href={this.state.random}
                rel="noopener noreferrer"
                target="_blank"
              >
                <img
                  alt="..."
                  className="creative-tim-logo"
                  src={require("assets/img/music.png")}
                ></img>
              </a>
            </Col>
            
            <Col lg={4} xs={12}>
              <h4>Contact Information</h4>
              <ul>
                <li>Aulas Formación B-3, Carretera Nacional II, KM 585,
              Martorell, 08760 Barcelona</li>
                <br /><br />
                <li>Planta 2 (Rambla de Canaletes), 08002 Barcelona</li>
              </ul>
            </Col>
          </Row>

          <Row  className="justify-content-center mt-5 mb-3">
            <div className="copyright" id="copyright">
              
              © {new Date().getFullYear()}, All rights reserved to{" "}

              <a href="https://github.com/Z-devs" rel="noopener noreferrer" target="_blank"> @Z Devs </a>

              {" "}| This webside is made by: {" "}

              <a href="https://github.com/oorellana95" rel="noopener noreferrer" target="_blank">@Oscar</a>
            
            </div>
          </Row>
        </Container>
      </footer>
    )
  }

  handleClick() {
    let music = [
      "https://youtu.be/mL7Gb6rcAAo", // Himno Oficial del POM Hotel Albano & Romina Power - Felicità Italiano Ragazzi Dance Remix
      "https://youtu.be/GJkuTx1DQzg", //Amelie Lens at Atomium in Brussels, Belgium for Cercle
      "https://youtu.be/Y6A_Czw8TFU", //Amelie Lens lockdown session at home
      "https://youtu.be/_WCur8LhH8I", //Awakenings Festival 2019 Sunday - Live set Amelie Lens @ Area Y
      "https://youtu.be/m30QEZG8aQA", //Carl Cox Techno DJ Set Live From The Off Sonar Closing Party Barcelona
      "https://youtu.be/FIMnXw_3Rgk", //Carl Cox live at The Brooklyn Mirage, NYC
      "https://youtu.be/vy-k0FopsmY", //Carl Cox Boiler Room Ibiza Villa Takeovers DJ Set
      "https://youtu.be/kwKrNtq9gHI", //Carl Cox Epic House Set From DJ Mag HQ Ibiza
      "https://youtu.be/k1d1twnD7Tk", //Bob Sinclar live from Studio Ibiza
      "https://youtu.be/yj2bHkkBS-Q", //Gabry Ponte - Live Felicità (di Albano & Romina Power) - (Full HD) - 31.08.2020 - Battiti live
      "https://youtu.be/A8gdkWOsc6Q", //Gabry Ponte - Medley Live - Battiti Live - estate 2020 - 31.08.2020
      "https://youtu.be/P867JatlH18", //Bob Sinclar - Live from Bob's Studio (Heineken powered by Defected)
    ]
    let random = [Math.round(0 + Math.random() * (music.length))];
    this.setState({ random: music[random] });
  }

}

export default Footer;
