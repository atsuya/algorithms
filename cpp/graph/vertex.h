#pragma once

#include <cinttypes>
#include <string>

class Vertex {
 public:
  Vertex() = delete;
  Vertex(const std::string name);
  Vertex(const Vertex&) = delete;
  Vertex& operator=(const Vertex&) = delete;

  std::string GetName() const;

 private:
  std::string name_;
};
