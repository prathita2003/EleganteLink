import { useEffect, useState } from "react";
import "./App.css";

function App() {
  const [url, setUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");
  const [links, setLinks] = useState([]);

  const API_URL = "http://localhost:8080";

  useEffect(() => {
    fetchLinks();
  }, []);

  const fetchLinks = async () => {
    const response = await fetch(`${API_URL}/api/links`);
    const data = await response.json();
    setLinks(data);
  };

  const shortenUrl = async () => {
    if (!url.trim()) return;

    const response = await fetch(`${API_URL}/api/links`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        originalUrl: url,
      }),
    });

    const data = await response.json();

    setShortUrl(data.shortUrl);
    setUrl("");
    fetchLinks();
  };

  const deleteLink = async (shortCode) => {
    await fetch(`${API_URL}/api/links/${shortCode}`, {
      method: "DELETE",
    });

    fetchLinks();

    if (shortUrl.includes(shortCode)) {
      setShortUrl("");
    }
  };

  const copyUrl = () => {
    navigator.clipboard.writeText(shortUrl);
  };

  return (
    <div className="app">

      <main>
        <h1>EleganteLink</h1>
        <p className="subtitle">Simple URL Shortener</p>

        <div className="shorten-box">
          <input
            type="text"
            placeholder="Enter your long URL"
            value={url}
            onChange={(e) => setUrl(e.target.value)}
          />

          <button onClick={shortenUrl}>
            Shorten URL
          </button>
        </div>

        {shortUrl && (
          <div className="result">
            <p>Your shortened URL:</p>

            <div className="result-row">
              <a href={shortUrl} target="_blank">
                {shortUrl}
              </a>

              <button onClick={copyUrl}>
                Copy
              </button>
            </div>
          </div>
        )}

        <section>
          <h2>Recent Links</h2>

          {links.length === 0 ? (
            <p>No links created yet.</p>
          ) : (
            links.map((link) => (
              <div className="link-row" key={link.id}>
                <span>{link.originalUrl}</span>

                <a
                  href={link.shortUrl}
                  target="_blank"
                >
                  {link.shortCode}
                </a>

                <button onClick={() => deleteLink(link.shortCode)}>
                  Delete
                </button>
              </div>
            ))
          )}
        </section>
      </main>

      <footer>
        © 2026 EleganteLink. All rights reserved.
      </footer>

    </div>
  );
}

export default App;