#pragma once

#include <cinttypes>
#include <string>

class Vertex {
 public:
  int32_t weight;
  std::string name;

  Vertex() = delete;

  Vertex(std::string name, int32_t weight);
};
